package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.SummaryNew;
import com.okancezik.financeai.repository.abstracts.SummaryNewsRepository;
import com.okancezik.financeai.service.abstracts.SummaryNewsService;
import com.okancezik.financeai.service.dto.requests.AddSummaryNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListSummaryNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummaryNewsManager implements SummaryNewsService {

    private final SummaryNewsRepository repository;
    private final ModelMapperService mapperService;
    @Override
    public void add(AddSummaryNewsRequestModel requestModel) {
        var data = this.mapperService.forRequest().map(requestModel, SummaryNew.class);
        this.repository.save(data);
    }

    @Override
    public ListSummaryNewsResponseModel getLastSummaryNew(int newsId) {
        var data = this.repository.findLastSummary(newsId);
        var news = this.mapperService.forResponse().map(data, ListSummaryNewsResponseModel.class);
        return news;
    }
}
