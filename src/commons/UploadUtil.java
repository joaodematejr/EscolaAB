package commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;



public class UploadUtil {
	private static final Map<String, String> TIPOS_PERMITIDOS = new HashMap<String, String>();
	private static final String PASTA_UPLOADS = "resources/documento/uploads/";
	static {
		TIPOS_PERMITIDOS.put("documento/pdf", "pdf");
		TIPOS_PERMITIDOS.put("documento/doc", "doc");
		TIPOS_PERMITIDOS.put("documento/xls", "xls");
		TIPOS_PERMITIDOS.put("documento/jpeg", "jpeg");
		TIPOS_PERMITIDOS.put("documento/png", "png");

	}

	public static String moverDocumento(Part documentoUploaded, String documentoAntigo) throws IOException {
		String nome = gerarNome(documentoUploaded);
		String caminhoAbsoluto = getCaminhoAbsoluto(nome);
		documentoUploaded.write(caminhoAbsoluto);
		removerDocumento(documentoAntigo);
		return nome;
	}

	private static String getCaminhoAbsoluto(String nome) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
				.getContext();
		return servletContext.getRealPath(PASTA_UPLOADS.concat(nome));
	}

	private static String gerarNome(Part documentoUploaded) {
		if (!TIPOS_PERMITIDOS.containsKey(documentoUploaded.getContentType())) {
			return null;
		}
		String novoNome = UUID.randomUUID().toString();
		return novoNome.concat(TIPOS_PERMITIDOS.get(documentoUploaded.getContentType()));

	}

	public static void removerDocumento(String nome) {
		if (nome == null || nome.isEmpty()) {
			return;
		}
		String caminhoAbsoluto = getCaminhoAbsoluto(nome);
		File file = new File(caminhoAbsoluto);
		if (file.exists()) {
			file.delete();
		}
	}
}
