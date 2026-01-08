package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("sortUsingFor")
@RequiredArgsConstructor
@Slf4j
public class SortUsingForServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;

    @Override
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingFor");
            return sortUsingFor(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingForServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    /**
     * FOR 문을 이용한 버블 정렬
     * @param sortTarget ("KEY" OR "VALUE")
     * @param sortOrder ("ASC" OR "DESC")
     * @return 정렬된 List
     */
    public List<Map<Integer, Integer>> sortUsingFor(String sortTarget, String sortOrder) {

        // 랜덤 숫자 값으로 구성된 List<Map<>> GET
        List<Map<Integer, Integer>> resultList = randomListUtil.generateRandomList(1, 100, 100);

        // 바깥 FOR 문 : 전체 리스트 순회
        for (int i = 0; i < resultList.size() - 1; i = i + 1) {
            // 안쪽 FOR 문 : 리스트의 각 요소 비교 (j는 0부터 마지막(정렬된 부분) 제외하면서 순회)
            for (int j = 0; j < resultList.size() - 1 - j; j = j + 1) {

                // 현재 Map, 다음 Map 추출
                Map<Integer, Integer> currentMap = resultList.get(j);
                Map<Integer, Integer> nextMap = resultList.get(j + 1);
                Integer currentTarget;
                Integer nextTarget;

                // sortTarget 에 따라 key, value 추출
                if (sortTarget.equals("KEY")) {
                    currentTarget = currentMap.entrySet().iterator().next().getKey();
                    nextTarget = nextMap.entrySet().iterator().next().getKey();
                } else {
                    currentTarget = currentMap.entrySet().iterator().next().getValue();
                    nextTarget = nextMap.entrySet().iterator().next().getValue();
                }

                // sortOrder 에 따라 비교 및 교체
                if (sortOrder.equals("ASC")) {                    // 오름차순
                    if (currentTarget > nextTarget) {             // current 가 next 보다 크면 교체
                        resultList.set(j, nextMap);
                        resultList.set(j + 1, currentMap);
                    }
                } else {                                          // 내림차순
                    if (currentTarget < nextTarget) {             // current 가 next 보다 작으면 교체
                        resultList.set(j, nextMap);
                        resultList.set(j + 1, currentMap);
                    }
                }


            }
        }

        return resultList;
    }
}
