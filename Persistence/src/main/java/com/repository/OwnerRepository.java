package com.repository;

import com.models.Owner;
import com.repository.interfaces.IOwnerRepository;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class OwnerRepository extends GenericRepository<Owner> implements IOwnerRepository {

    public void addOwner(final String name, final String surname){
        Owner owner = new Owner(name, surname);
        super.save(owner);
    }
}
