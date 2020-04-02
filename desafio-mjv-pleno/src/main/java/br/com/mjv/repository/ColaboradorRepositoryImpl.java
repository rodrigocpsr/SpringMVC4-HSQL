package br.com.mjv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.model.Colaborador;
import br.com.mjv.util.ConstantsSQL;

@Repository
public class ColaboradorRepositoryImpl implements ColaboradorRepository {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public Colaborador findByName(String nome) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", nome);
        Colaborador result = namedParameterJdbcTemplate.queryForObject(ConstantsSQL.SQL_FIND_BY_NAME, params, new ColaboradorMapper());
        return result;
	}
	
	@Override
	public List<Colaborador> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
        List<Colaborador> result = namedParameterJdbcTemplate.query(ConstantsSQL.SQL_FIND_ALL, params, new ColaboradorMapper());
        return result;
	}
	
	private static final class ColaboradorMapper implements RowMapper<Colaborador> {

		public Colaborador mapRow(ResultSet rs, int rowNum) throws SQLException {
			Colaborador colaborador = new Colaborador();
			colaborador.setIdcolaborador(rs.getInt("idcolaborador"));
			colaborador.setNome(rs.getString("nome"));
			colaborador.setSobrenome(rs.getString("sobrenome"));
			colaborador.setEmail(rs.getString("email"));
			colaborador.setDepartamento(rs.getString("departamento"));
			colaborador.setGestor(rs.getString("gestor"));
			colaborador.setProjeto(rs.getString("projeto"));
			return colaborador;
		}
		
	}
	
	@Override
	public void excluir(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		namedParameterJdbcTemplate.update(ConstantsSQL.SQL_DELETE, params);
	}
	
	@Override
	public void alterar(Colaborador colaborador) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idcolaborador", colaborador.getIdcolaborador());
        params.put("nome", colaborador.getNome());
		params.put("sobrenome", colaborador.getSobrenome());
        params.put("email", colaborador.getEmail());
		params.put("projeto", colaborador.getProjeto() == "" ? null : colaborador.getProjeto());
        params.put("departamento", colaborador.getDepartamento() == "" ? null : colaborador.getDepartamento());
        params.put("gestor", colaborador.getGestor() == "" ? null : colaborador.getGestor());
		namedParameterJdbcTemplate.update(ConstantsSQL.SQL_UPDATE, params);
	}
		
	@SuppressWarnings("deprecation")
	@Override
	public Long getTotalColaborador(Integer id) throws Exception { 
		Map<String, Object> params = new HashMap<String, Object>();
    	params.put("id", id);
    	Long result = namedParameterJdbcTemplate.queryForLong(ConstantsSQL.SQL_FIND_BY_ID, params);
    	return result;
	}

	@Override
	public void adicionar(Colaborador colaborador) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", colaborador.getNome());
		params.put("sobrenome", colaborador.getSobrenome());
        params.put("email", colaborador.getEmail());
		params.put("projeto", colaborador.getProjeto());
        params.put("departamento", colaborador.getDepartamento());
        params.put("gestor", colaborador.getGestor());
        namedParameterJdbcTemplate.update(ConstantsSQL.SQL_INSERT, params);
	}
	
}
