package org.example.demooo.dao.repository;

import org.example.demooo.dao.entity.StudentEntity;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class Studentrepository {

    private final Connection connection;

    public Studentrepository(Connection connection) {
        this.connection = connection;
    }

    public void save(StudentEntity student) {
        String query = "insert into students (name, surname, age) values (?, ?, ?)";

        try  {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, student.getName());
            prepareStatement.setString(2, student.getSurname());
            prepareStatement.setInt(3, student.getAge());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<StudentEntity> findAll() {
        String query = "select*from students";
        List<StudentEntity> students = new ArrayList<>();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                students.add(new StudentEntity(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return students;
    }

    public StudentEntity findById(Long id) {
        String query = "Select*from students where id = ?";
        StudentEntity student = null;

        try  {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setLong(1, id);

            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new StudentEntity(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getInt("age")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return student;
    }

    public void deleteById(Long id) {
        String query = "delete from students where id = ?";

        try  {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}