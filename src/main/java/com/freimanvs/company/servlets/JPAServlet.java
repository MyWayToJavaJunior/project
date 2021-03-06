package com.freimanvs.company.servlets;

import com.freimanvs.company.entities.Employee;
import com.freimanvs.company.entities.Role;
import com.freimanvs.company.util.RestoreData;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/JPAServlet")
public class JPAServlet extends HttpServlet {

    public static final String PERSISTENCE_UNIT_NAME = "jpa";
    private  static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //initialization
//        RestoreData.restoreJDBC();

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            Query q = em.createQuery("from Employee");
            List<Employee> result = q.getResultList();
            try (PrintWriter pw = response.getWriter()){
                result.forEach(pw::println);
            }
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
            throw new ServletException(e);
        }
        finally {
            em.close();
        }
    }
}