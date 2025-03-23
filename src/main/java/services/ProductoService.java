package services;

import java.util.List;

import models.Producto;

public interface ProductoService {
	List<Producto> listarProductosPorIdSubcategoria(Integer idSubcategoria);
	List<Producto> listarDetalleProducto(Integer idProducto);
}
