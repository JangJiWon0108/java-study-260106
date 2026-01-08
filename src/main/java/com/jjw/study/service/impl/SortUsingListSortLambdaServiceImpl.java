package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service("sortUsingListSortLambda")
@RequiredArgsConstructor
@Slf4j
public class SortUsingListSortLambdaServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;
    /**
     * ListSortLambda 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingListSortLambda");
            return sortUsingListSortLambda(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingListSortLambdaServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    public List<Map<Integer, Integer>> sortUsingListSortLambda(String sortTarget, String sortOrder) {

        List<Map<Integer, Integer>> resultList = randomListUtil.generateRandomList(1, 100, 100);

        Comparator<Map<Integer, Integer>> comp = getComparator(sortTarget, sortOrder);

        resultList.sort(comp);

        return resultList;
    }

    public static Comparator<Map<Integer, Integer>> getComparator (String sortTrget, String sortOrder) {

        // 람다표현식
        return (Map<Integer, Integer> currentMap, Map<Integer, Integer> nextMap) -> {

            Integer currentTarget;
            Integer nextTarget;

                if (sortTrget.equals("KEY")) {
                currentTarget = currentMap.entrySet().iterator().next().getKey();
                nextTarget = nextMap.entrySet().iterator().next().getKey();
            } else {
                currentTarget = currentMap.entrySet().iterator().next().getValue();
                nextTarget = nextMap.entrySet().iterator().next().getValue();
            }

                if (sortOrder.equals("ASC")) {
                if (currentTarget > nextTarget) {
                    return 1;
                } else if (currentTarget < nextTarget) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                if (currentTarget > nextTarget) {
                    return -1;
                } else if (currentTarget < nextTarget) {
                    return 0;
                } else {
                    return 0;
                }
            }
        };
    }
}
