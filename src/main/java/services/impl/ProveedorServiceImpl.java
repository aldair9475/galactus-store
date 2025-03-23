package services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.ProveedorMapper;
import models.Proveedor;
import services.ProveedorService;

public class ProveedorServiceImpl implements ProveedorService{

	@Override
	public List<Proveedor> listarProveedores(Integer idProveedor) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProveedorMapper proveedorMapper = session.getMapper(ProveedorMapper.class);
			return proveedorMapper.listarProveedores(idProveedor);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
