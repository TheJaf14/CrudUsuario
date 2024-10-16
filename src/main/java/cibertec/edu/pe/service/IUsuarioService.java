package cibertec.edu.pe.service;

import java.io.FileNotFoundException;
import java.util.*;
import cibertec.edu.pe.model.Usuario;
import net.sf.jasperreports.engine.JRException;

public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios();
	public Usuario guardarUsuario(Usuario usuario);
	public Optional<Usuario> buscarUsuario(int codigo);
	public void eliminarUsuario(int codigo);
	byte[] exportPdf() throws JRException, FileNotFoundException;
	
}
