package service;

import dao.config.ClassRoomDao;
import dao.config.HocVienDao;
import model.ClassRoom;
import model.HocVien;

import java.util.List;

public class ClassRoomService {

    public List<ClassRoom> getAll(){
        return ClassRoomDao.getAll();
    }
}
