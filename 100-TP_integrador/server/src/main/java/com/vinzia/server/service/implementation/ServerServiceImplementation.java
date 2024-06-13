package com.vinzia.server.service.implementation;

import com.vinzia.server.model.Server;
import com.vinzia.server.service.ServerService;

import java.util.Collection;
import java.util.List;

public class ServerServiceImplementation implements ServerService {
    @Override
    public Server create(Server server) {
        return null;
    }

    @Override
    public Server ping(String ipAddress) {
        return null;
    }

    @Override
    public Collection<Server> list(int limit) {
        return List.of();
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
