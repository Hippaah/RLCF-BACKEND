package com.rlcf.spring.services.ServiceImpl;

import com.rlcf.spring.models.Log;
import com.rlcf.spring.services.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogImpl implements LogService {

    @Override
    public void update(Log log) {

    }
}
