package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Marca;
import models.Producto;
import models.Proveedor;
import services.MarcaService;
import services.ProductoService;
import services.ProveedorService;
import services.impl.MarcaServiceImpl;
import services.impl.ProductoServiceImpl;
import services.impl.ProveedorServiceImpl;

/**
 * Servlet implementation class DetalleProductoServlet
 */
@WebServlet("/detalle-producto")
public class DetalleProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductoService productoService;
	private final MarcaService marcaService;
	private final ProveedorService proveedorService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetalleProductoServlet() {
		super();
		productoService = new ProductoServiceImpl();
		marcaService = new MarcaServiceImpl();
		proveedorService = new ProveedorServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Producto> productos = productoService.listarDetalleProducto(id);

		List<String> imagenes = new ArrayList<>();
		for (Producto producto : productos) {

			imagenes.add(producto.getImagenUrl());
		}
		
		List<Marca> marcas = new ArrayList<Marca>();
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		
		for (Producto producto : productos) {
			marcas = marcaService.listarMarcas(producto.getIdMarca());
			proveedores = proveedorService.listarProveedores(producto.getIdProveedor());
			
		}
		
		System.out.println("MARCAS :"+marcas.size());
		System.out.println("Provedor: "+proveedores.size());
		System.out.println("PRodcutos : "+productos.size());
		System.out.println("Imagenes : "+imagenes.size());

		request.setAttribute("marcas", marcas);
		request.setAttribute("proveedores", proveedores);
		request.setAttribute("imagenes", imagenes);
		request.setAttribute("productos", productos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/detalle-producto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
