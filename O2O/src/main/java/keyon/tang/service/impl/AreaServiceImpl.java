package keyon.tang.service.impl;

import keyon.tang.dao.AreaDao;
import keyon.tang.entity.Area;
import keyon.tang.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/12 10:04
 * @Version 1.0
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.getAreaList();
    }
}
