package com.example.employeeDirectory.core.utulitites.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    public ModelMapper forResponse() ;
    public ModelMapper forRequest() ;

}
