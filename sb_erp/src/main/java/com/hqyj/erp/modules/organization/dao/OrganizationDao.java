package com.hqyj.erp.modules.organization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;
import com.hqyj.erp.modules.organization.vo.ZtreeModel;

@Repository
@Mapper
public interface OrganizationDao {
	
	@Select("select * from department")
	List<Department> getDepartments();

	@Select("select * from department where depart_id = #{departId}")
	Department getDepartmentById(int departId);
	
	@Select("select * from department where depart_name = #{departName}")
	Department getDepartmentByName(String departName);
	
	@Insert("insert into department(depart_name,depart_desc) values(#{departName},#{departDesc})")
	void insertDepartment(Department department);
	
	@Update("update department set depart_name=#{departName}, depart_desc=#{departDesc} "
			+ "where depart_id=#{departId}")
	void updateDepartment(Department department);
	
	@Delete("delete from department where depart_id=#{departId}")
	void deleteDepartment(int departId);
	
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id ")
	List<Position> getPositions();
	
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id "
			+ "where p.depart_id = #{departId}")
	List<Position> getPositionsByDepartId(int departId);
	
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id "
			+ "where p.position_id=#{positionId}")
	Position getPositionById(int positionId);
	
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id "
			+ "where d.depart_name=#{positionName}")
	Position getPositionByName(String positionName);
	
	@Insert("insert into position (position_name, position_description, depart_id) "
			+ "values (#{positionName},#{positionDescription},#{departId})")
	void insertPosition(Position position);
	
	@Update("update position set position_name=#{positionName}, "
			+ "position_description=#{positionDescription}, depart_id=#{departId} "
			+ "where position_id=#{positionId}")
	void updatePosition(Position position);
	
	@Delete("delete from position where position_id=#{positionId}")
	void deletePosition(int positionId);
	
	@Select("select depart_id as id, depart_name as name from department")
	List<ZtreeModel> getOrgTree();
}
