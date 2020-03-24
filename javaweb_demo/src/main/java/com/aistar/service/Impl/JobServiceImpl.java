package com.aistar.service.Impl;

import com.aistar.pojo.Job;
import com.aistar.service.JobService;

import java.util.ArrayList;
import java.util.List;

public class JobServiceImpl implements JobService {
    @Override
    public boolean add(Job job) {
        return false;
    }

    @Override
    public boolean modify(Job job) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Job getById(Integer id) {
        return null;
    }

    @Override
    public List<Job> getAll() {
        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job());
        jobList.add(new Job());
        jobList.add(new Job());
        jobList.add(new Job());
        jobList.add(new Job());
        return jobList;
    }
}
