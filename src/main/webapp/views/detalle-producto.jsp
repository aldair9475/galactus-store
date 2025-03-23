<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Producto"%>
<%@ page import="models.Marca"%>
<%@ page import="models.Proveedor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GALACTUS STORE | SISE</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
</head>
<body>

	<header>
		<div class="flex gap-4 bg-green-600 justify-center h-[50px] items-center">
			<a href="/galactus-store" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Inicio</a>
			<a href="/galactus-store/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer border border-white border-solid">Categorías</a>
			<a class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Marcas</a>
		</div>
	</header>


	<%
	int contador = 1;
	List<Marca> marcas = (List<Marca>) request.getAttribute("marcas");
	List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
	List<Producto> productos = (List<Producto>) request.getAttribute("productos");
	
	if (productos != null && !productos.isEmpty()) {
		if(marcas != null && !marcas.isEmpty()){
			if(proveedores != null && !proveedores.isEmpty()){
				for (Producto producto : productos) {
					for(Marca marca : marcas){
						for(Proveedor proveedor : proveedores){			
					if (contador == 1) {	
	%>
	<div class="max-w-4xl mx-auto bg-white p-6 rounded-lg shadow-md">
		<!-- Nombre del producto -->
		<h1 class="text-2xl font-bold text-center mb-6">
			<%=producto.getNombre()%></h1>

		<div class="flex flex-col md:flex-row">
			<!-- Imagen del producto -->
			<div class="md:w-1/2">
				<%
				List<String> imagenes = (List<String>) request.getAttribute("imagenes");
				if (imagenes != null && !imagenes.isEmpty()) {
				%>
				<img id="productoImagen" src="<%=imagenes.get(0)%>" alt="Producto"
					class="rounded-lg w-50 h-50">
				<%
				}
				%>

				<ul class="flex justify-center mt-5 space-x-2">
					<%
					if (imagenes != null && !imagenes.isEmpty()) {
						int index = 1;
						for (String imagen : imagenes) {
					%>
					<li
						class="bg-gray-300 hover:bg-green-600 px-2 py-1 rounded-full cursor-pointer">
						<a href="#" onclick="cambiarImagen('<%=imagen%>')"><%=index++%></a>
					</li>
					<%
					}
					}
					%>
				</ul>
			</div>

			<!-- Detalles del producto -->
			<div class="md:w-1/2 md:pl-6">
				<div class="mb-4">
					<p class="text-lg"><strong>Modelo :</strong><%=producto.getModelo()%></p>					
            	<p class="text-lg flex items-center">
            		<strong>Marca:</strong>
            		<span class="flex items-center gap-2 ml-2">
                	<%= marca.getNombre()%>
                	<img src="<%= (marca != null && marca.getImagenUrl() != null) ? marca.getImagenUrl() : "No Dispponible" %>"  alt="Logo de la marca" class="w-8 h-8">
            		</span>
        		</p>
					<p class="text-lg"><strong>Codigo Interno : </strong><%=producto.getCodigoInterno()%></p>						
					<p class="text-lg"><strong>Garantía : </strong><%=producto.getTiempoGarantiaMeses()%> meses</p>																						
					<p class="text-lg"><strong>Proveedor : </strong> <%= proveedor.getNombres() %></p>
					<p class="text-lg"><strong>Precio : </strong> S/<%=producto.getPrecio()%></p>
					<p class="text-lg"><strong>Stock : </strong><%=producto.getStock()%> unidades</p>
				</div>
			</div>
		</div>

		<!-- Descripción del producto -->
		<div class="mt-6">
			<h2 class="text-xl font-bold mb-4">Descripción del Producto</h2>
			<p class="text-gray-700">
				<%=producto.getDescripcion()%>

			</p>
		</div>
	</div>
	<%
	contador++;
	}
	%>
	<%
	}
	}
	}
	}
	}
	}
	%>



	<script>
		function cambiarImagen(imagenUrl) {
			const productoImagen = document.getElementById('productoImagen');
			productoImagen.src = imagenUrl;
		}
	</script>
</body>
</html>