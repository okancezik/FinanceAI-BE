package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.SummaryNew;
import com.okancezik.financeai.repository.abstracts.SummaryNewsRepository;
import com.okancezik.financeai.service.abstracts.SummaryNewsService;
import com.okancezik.financeai.service.dto.requests.AddSummaryNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListSummaryNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SummaryNewsManager implements SummaryNewsService {

    private final SummaryNewsRepository repository;
    private final ModelMapperService mapperService;
    @Override
    public boolean add(AddSummaryNewsRequestModel requestModel) {
        var data = this.mapperService.forRequest().map(requestModel, SummaryNew.class);
        try{
            this.repository.save(data);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    @Override
    public List<ListSummaryNewsResponseModel> getSummariesByNewsId(int newsId) {
        var data = this.repository.findByNewsId(newsId);
        if (!data.isEmpty()){
            var news = data.stream().map(x->this.mapperService.forResponse()
                    .map(x, ListSummaryNewsResponseModel.class))
                    .collect(Collectors.toList());
            return news;
        }
        return null;
    }

    @Override
    public ListSummaryNewsResponseModel getLastSummaryNew(int newsId) {
        var data = this.repository.findLastSummary(newsId);
        if(data.isPresent()){
            var news = this.mapperService.forResponse().map(data, ListSummaryNewsResponseModel.class);
            return news;
        }
        return null;
    }
}
