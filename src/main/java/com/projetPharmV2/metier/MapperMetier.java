package com.projetPharmV2.metier;

public interface MapperMetier<R,E> {

	E mapper(R rest);

	R mapperInverse(E entity);
}
