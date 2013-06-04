package masterfila.jsf.dao;

import java.util.List;

import masterfila.jsf.util.Constants;
import masterfila.jsf.util.HibernateUtil;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class Dao {
	
	private static Dao instance;
	private Session sessao;
	private Transaction tx;
	
	private Dao(){
		
	}
	
	public static Dao getInstance(){
		if(instance == null)
			instance = new Dao();
		return instance;
	}
	
	
	public <T> Object buscarPorId(Class<T> clazz, Long id){
		try{
			sessao = HibernateUtil.getSession();
			Object object = sessao.get(clazz, id);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> Object buscarPorChaveUnicaLong(Class<T> clazz, Long longo, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			Object object = sessao.createCriteria(clazz).add(Restrictions.eq(coluna, longo)).uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	//método alterado para retornar apenas entradas ativas.
	public <T> Object buscarPorChaveUnicaString(Class<T> clazz, String stringi, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq(coluna, stringi));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			Object object = c.uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> List<T> buscarPorChaveEstrangeira(Class<T> clazz, Object objetoEstrangeiro, String colunaEstrangeira){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq(colunaEstrangeira, objetoEstrangeiro));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			return c.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean salvarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.save(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(sessao!=null)
			sessao.close();
		}
	}
	
	public <T> boolean salvarOuAtualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.saveOrUpdate(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}

	public <T> boolean atualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			sessao.setCacheMode(CacheMode.IGNORE);
			tx = sessao.beginTransaction();
			sessao.update(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean mesclarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.merge(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean deletarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.delete(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> listarObjetos(Class<?> classe){
		try{
			sessao = HibernateUtil.getSession();
			Criteria criteria = sessao.createCriteria(classe);
			return criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
		
	public List<?> criarQuery(String query){
		try{
			sessao = HibernateUtil.getSession();
			Query select = sessao.createQuery(query);
			return select.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public Object selectObjeto(String query){
		try{
			sessao = HibernateUtil.getSession();
			Object obj = sessao.createQuery(query).uniqueResult();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarPorLike(String coluna, String queryPart, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.like(coluna, queryPart, MatchMode.ANYWHERE));
			c.add(Restrictions.like("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	// metodo alterado para buscar somente ativos
	public List<?> buscarPorLikeIlimitado(String [] colunas, String [] querys, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			for(int i = 0; i < colunas.length; i++){
				c.add(Restrictions.like(colunas[i], querys[i], MatchMode.ANYWHERE));
			}
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	// metodo alterado para buscar somente ativos
	public List<?> buscarPorLikeIgnoreCase(String coluna, String queryPart, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.ilike(coluna, queryPart, MatchMode.ANYWHERE));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
}
