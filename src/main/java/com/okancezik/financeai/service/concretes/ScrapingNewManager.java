package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.ScrapingNew;
import com.okancezik.financeai.repository.abstracts.ScrapingNewRepository;
import com.okancezik.financeai.service.abstracts.ScrapingNewService;
import com.okancezik.financeai.service.dto.requests.AddScrapingNews;
import com.okancezik.financeai.service.dto.responses.ListScrapingNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScrapingNewManager implements ScrapingNewService {

    private final ScrapingNewRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public boolean add(AddScrapingNews requestModel) {
       try{
           var data = this.mapperService.forRequest().map(requestModel, ScrapingNew.class);
           this.repository.save(data);
       }catch (Exception e){
           return false;
       }
       return true;
    }

    @Override
    public List<ListScrapingNewsResponseModel> getScrapiedNews(int lotId) {
        var data = this.repository.findByNews_LotId(lotId);
        if (!data.isEmpty()){
            var response = data.stream().map(x
                    -> this.mapperService.forResponse().map(x, ListScrapingNewsResponseModel.class))
                    .collect(Collectors.toList());
            return response;
        }
        return null;
    }
}
