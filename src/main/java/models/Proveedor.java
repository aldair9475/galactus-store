package models;

public class Proveedor {
	
	
	    private int idProveedor;         
	    private char tipoDocumento;      
	    private String documentoIdentidad;
	    private String nombres;          
	    private String apellidoPaterno;  
	    private String apellidoMaterno;  
	    private String correo;           
	    private String telefono;        
	    private String direccion;       
	    private String codigoPais;
	    
		public int getIdProveedor() {
			return idProveedor;
		}
		public void setIdProveedor(int idProveedor) {
			this.idProveedor = idProveedor;
		}
		public char getTipoDocumento() {
			return tipoDocumento;
		}
		public void setTipoDocumento(char tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}
		public String getDocumentoIdentidad() {
			return documentoIdentidad;
		}
		public void setDocumentoIdentidad(String documentoIdentidad) {
			this.documentoIdentidad = documentoIdentidad;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellidoPaterno() {
			return apellidoPaterno;
		}
		public void setApellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
		}
		public String getApellidoMaterno() {
			return apellidoMaterno;
		}
		public void setApellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getCodigoPais() {
			return codigoPais;
		}
		public void setCodigoPais(String codigoPais) {
			this.codigoPais = codigoPais;
		} 

	    
}
