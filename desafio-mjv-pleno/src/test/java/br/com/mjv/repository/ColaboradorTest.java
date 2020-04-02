package br.com.mjv.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import br.com.mjv.model.Colaborador;
import br.com.mjv.repository.ColaboradorRepository;
import br.com.mjv.repository.ColaboradorRepositoryImpl;

public class ColaboradorTest {

    private EmbeddedDatabase db;

    ColaboradorRepository colaboradorRepository;
    
    @Before
    public void setUp() {
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-data.sql")
    		.build();
    }

    @Test
    public void testFindByname() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	ColaboradorRepositoryImpl colaboradorRepository = new ColaboradorRepositoryImpl();
    	colaboradorRepository.setNamedParameterJdbcTemplate(template);
    	
    	Colaborador colaborador = colaboradorRepository.findByName("Rodrigo");
  
    	Assert.assertNotNull(colaborador);
    	Assert.assertEquals(4, colaborador.getIdcolaborador().intValue());
    	Assert.assertEquals("Rodrigo", colaborador.getNome());
    	Assert.assertEquals("Rodrigues", colaborador.getSobrenome());
    	Assert.assertEquals("rodrigocpsr@hotmail.com", colaborador.getEmail());
    	Assert.assertEquals("Seguros", colaborador.getDepartamento());
    	Assert.assertEquals("Marcia", colaborador.getGestor());
    	Assert.assertEquals("PRJ Vendas", colaborador.getProjeto());
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
