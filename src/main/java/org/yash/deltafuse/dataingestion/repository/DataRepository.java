package org.yash.deltafuse.dataingestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.yash.deltafuse.dataingestion.model.HighDemand;

/**
 * Created by sandeep.sutar on 3/4/2019.
 */
@Component
public interface DataRepository extends CrudRepository<HighDemand, String>{
	
	 @Override
	 List<HighDemand> findAll();
	 
	 @Override
	 <S extends HighDemand> List<S> saveAll(Iterable<S> entities);

	
    /*@Autowired
    JdbcTemplate template;

    Getting all Items from table
    public List<DataItem> getAllItems(){
        List<DataItem> items = template.query("select id, name,category from item",(result,rowNum)->new DataItem(result.getInt("id"),
                result.getString("name"),result.getString("category")));
        return items;
    }

    Getting a specific item by item id from table
    public DataItem getItem(int id ){
        String query = "SELECT * FROM ITEM WHERE ID=?";
        DataItem item = template.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(DataItem.class));

        return item;
    }

    Adding an item into database table
    public int addItem(int id,String name,String category){
        String query = "INSERT INTO ITEM VALUES(?,?,?)";
        return template.update(query,id,name,category);
    }

    delete an item from database
    public int deleteItem(int id){
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query,id);
    }

    public int updateItem(int id){
        String query = "UPDATE ITEM NAME,CATEGORY WHERE ID =?";
        return template.update(query,id);
    }*/
}
