package kr.co.wecky.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.wecky.dto.AdminDto;

@Mapper
public interface AdminMapper {

	int adminInsert(@Param("adminDto") AdminDto adminDto);

	AdminDto loginConfirm(@Param("adminDto") AdminDto adminDto);

	List<AdminDto> adminList();

	int updateAdminAccount(String id);

	void updateAdmin(@Param("adminDto") AdminDto adminDto);

	List<AdminDto> searchKeyword(Map<String, Object> params);

}
