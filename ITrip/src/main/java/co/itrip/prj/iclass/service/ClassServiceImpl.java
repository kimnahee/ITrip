package co.itrip.prj.iclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.iclass.mapper.ClassMapper;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private ClassMapper map;

	@Override
	public List<ClassVO> classSelectList(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classSelectList(vo);
	}

	@Override
	public ClassVO classSelect(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classSelect(vo);
	}

	@Override
	public int classInsert(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classInsert(vo);
	}

	@Override
	public int classDelete(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classDelete(vo);
	}

}
