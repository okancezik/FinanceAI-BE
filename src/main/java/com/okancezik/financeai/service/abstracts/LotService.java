package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.responses.ListLotResponseModel;

import java.util.List;

public interface LotService {
    List<ListLotResponseModel> getAllLot();

    ListLotResponseModel getLotDetail(int id);
}
