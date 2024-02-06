package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int CALORIES_PER_DAY_LIMIT = 2000;

    public static List<MealTo> filteredByStreams(List<Meal> meals, int caloriesPerDay, LocalTime startTime, LocalTime endTime) {
        return convertToMealsTo(meals, caloriesPerDay).stream()
                .filter(mealTo -> TimeUtil.isBetweenHalfOpen(mealTo.getDateTime().toLocalTime(), startTime, endTime))
                .collect(Collectors.toList());
    }

    public static List<MealTo> convertToMealsTo(List<Meal> meals, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
//                      Collectors.toMap(Meal::getDate, Meal::getCalories, Integer::sum)
                );

        return meals.stream()
                .map(meal -> createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    private static MealTo createTo(Meal meal, boolean excess) {
        return new MealTo(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
}
