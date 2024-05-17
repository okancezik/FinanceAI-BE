package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.core.utils.results.ErrorResult;
import com.okancezik.financeai.core.utils.results.Result;
import com.okancezik.financeai.core.utils.results.SuccessResult;
import com.okancezik.financeai.entity.concretes.Target;
import com.okancezik.financeai.repository.abstracts.TargetRepository;
import com.okancezik.financeai.service.abstracts.TargetService;
import com.okancezik.financeai.service.dto.requests.AddTargetRequestModel;
import com.okancezik.financeai.service.dto.responses.ListUserTargetResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class TargetManager implements TargetService {

    private final TargetRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public Result add(AddTargetRequestModel requestModel) {
        var userLastTarget = this.repository.findLastTarget(requestModel.getUserId());
        if (userLastTarget.isPresent()){
            var days = ChronoUnit.DAYS.between(userLastTarget.get().getLoadDate(), requestModel.getLoadDate());
            if (days < 30)return new ErrorResult("User's already have a target for this month");
        }
        var data = this.mapperService.forRequest().map(requestModel, Target.class);
        this.repository.save(data);
        return new SuccessResult("Added user's target");
    }

    @Override
    public ListUserTargetResponseModel getTargetByUserId(int id) {
        var data = this.repository.findLastTarget(id);
        if(data.isPresent()){
            var target = this.mapperService.forResponse().map(data.get(),ListUserTargetResponseModel.class);
            return target;
        }
        return null;
    }
}
