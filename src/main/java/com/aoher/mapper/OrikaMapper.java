package com.aoher.mapper;

import com.aoher.model.Client;
import com.aoher.persistence.ClientEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class OrikaMapper extends ConfigurableMapper {

    public MapperFactory mappClientDaoToClient(MapperFactory factory) {
        factory.classMap(ClientEntity.class, Client.class)
                .byDefault()
                .register();
        return factory;
    }
}
