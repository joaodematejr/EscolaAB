package mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import commons.UploadUtil;
import entity.Turma;
import entity.Documento;
import rn.ArquivoRN;
import rn.TurmaRN;

@ViewScoped
@ManagedBean
public class ArquivoMb {
	private String turmaId;
	private Turma turma;
	private Documento docu;
	private Part docuUploaded;
	private List<Documento> documentos;
	private ArquivoRN arquivoRN;
	private TurmaRN turmaRN;

	@PostConstruct
	public void init() {
		turmaRN = new TurmaRN();
		arquivoRN = new ArquivoRN();
		docu = new Documento();
		turma = new Turma();

	}

	public String getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(String turmaId) {
		this.turmaId = turmaId;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Documento getDocu() {
		return docu;
	}

	public void setDocu(Documento docu) {
		this.docu = docu;
	}

	public Part getDocuUploaded() {
		return docuUploaded;
	}

	public void setDocuUploaded(Part docuUploaded) {
		this.docuUploaded = docuUploaded;
	}

	public List<Documento> getDocumentos() {
		if (documentos == null && turma != null && turma.getId() != null) {
			documentos = arquivoRN.listarDocumentoPorTurma(turma.getId());
		}
		return documentos;
	}

	public void load() {
		if (turmaId != null) {
			Long id = Long.parseLong(turmaId);
			turma = turmaRN.buscarPorId(id);
		}
	}

	public void excluir(String idDoc) {
		Long id = Long.parseLong(idDoc);
		Documento doc = arquivoRN.buscarDocumentoPorID(id);
		UploadUtil.removerDocumento(doc.getNomeDocumento());
		arquivoRN.excluir(doc);
		documentos = null;
	}

	public String salvar() {
		try {
			String nome = UploadUtil.moverDocumento(docuUploaded, docu.getNomeDocumento());
			docu.setNomeDocumento(nome);
			docu.setTurma(turma);
			arquivoRN.adicionar(docu);
			return "/album?idturma=" + turma.getId().toString() + "&faces-redirect=true";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public ArquivoRN getArquivoRN() {
		return arquivoRN;
	}

	public void setArquivoRN(ArquivoRN arquivoRN) {
		this.arquivoRN = arquivoRN;
	}

	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

}
