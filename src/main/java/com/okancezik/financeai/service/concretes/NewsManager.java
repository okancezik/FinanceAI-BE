package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.News;
import com.okancezik.financeai.repository.abstracts.NewsRepository;
import com.okancezik.financeai.service.abstracts.NewsService;
import com.okancezik.financeai.service.dto.requests.AddNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsManager implements NewsService {

    private final NewsRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public void add(AddNewsRequestModel requestModel) {
        var data = this.mapperService.forRequest().map(requestModel, News.class);
        this.repository.save(data);
    }

    @Override
    public List<ListNewsResponseModel> findAll() {
        return null;
    }
}
