package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.zip.InflaterInputStream;

@Service("sortUsingListSortComparator")
@RequiredArgsConstructor
@Slf4j
public class SortUsingListSortComparatorServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;
    /**
     * ListSortComparator 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingListSortComparator");
            return sortUsingListSortComparator(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingListSortComparatorServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    public List<Map<Integer, Integer>> sortUsingListSortComparator(String sortTarget, String sortOrder) {

        List<Map<Integer,Integer>> resultList = randomListUtil.generateRandomList(1, 100, 100);

        Comparator<Map<Integer, Integer>> comp = getComparator(sortTarget, sortOrder);

        resultList.sort(comp);

        return resultList;
    }

    public static Comparator<Map<Integer, Integer>> getComparator(String sortTarget, String sortOrder) {

        return new Comparator<Map<Integer, Integer>>() {

            @Override
            public int compare(Map<Integer, Integer> currentMap, Map<Integer, Integer> nextMap) {

                Integer currentTarget;
                Integer nextTarget;

                if (sortTarget.equals("KEY")) {
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
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        };
    }
}
