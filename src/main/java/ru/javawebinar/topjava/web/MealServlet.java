package ru.javawebinar.topjava.web;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class MealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MealTo> mealsTo = MealsUtil.convertToMealsTo(MealsUtil.getMeals(),MealsUtil.CALORIES_PER_DAY_LIMIT);
        req.setAttribute("mealsTo", mealsTo);
        req.getRequestDispatcher("/meals.jsp").forward(req, resp);

    }
}
