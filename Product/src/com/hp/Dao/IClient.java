/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Client;
import java.util.List;

/**
 *
 * @author Muggle
 */
public interface IClient {

    public List<Client> getClient(String str);

    public boolean findByClient(Client c);

    public int addClient(Client c);

    public int deleteClient(String clientid);

    public int updateClient(Client c);
    public List searchClient(String str);
}
