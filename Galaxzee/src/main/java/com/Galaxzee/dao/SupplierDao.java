package com.Galaxzee.dao;

import java.util.List;

import com.Galaxzee.model.Supplier;

public interface SupplierDao 
{
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierId);

	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSupplier();
}
