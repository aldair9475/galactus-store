package dao;

import java.util.List;

import models.Producto;

public interface ProductoMapper {
	List<Producto> listarProductosPorIdSubcategoria(Integer idSubcategoria);
	List<Producto> listarDetalleProducto(Integer idProducto);
}
