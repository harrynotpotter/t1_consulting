package com.example.t1_consulting.repositories;

import com.example.t1_consulting.models.entity.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository {
    @Autowired
    SessionFactory factory;

    /**
     * Метод обновления заметки
     * @param note Обновляемая заметка
     * @return Результат обновления сохранённый в базе
     */
    public Note update(Note note) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Note note1 = (Note)session.createQuery("from Note where id = '" + note.getId() + "'").getSingleResult();
        note1.setName(note.getName());
        note1.setDate(note.getDate());
        note1.setText(note.getText());
        session.save(note1);
        session.getTransaction().commit();
        return note1;
    }

    /**
     * Метод добавления заметки
     * @param note Добавляемая заметка
     * @return Результат обновления сохранённый в базе
     */
    public Note save(Note note) {
        Session session = factory.getCurrentSession();
        Note note1 = new Note(note.getName(), note.getText(), note.getDate());
        session.beginTransaction();
        session.save(note1);
        session.getTransaction().commit();
        return note1;
    }

    /**
     * Метод удаления заметки
     * @param id Удаляемой заметки
     */
    public void delete(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Note> notes = session.createQuery("from Note where id = '" + id + "'").getResultList();
        for (Note n : notes) {
            session.remove(n);
        }
        session.getTransaction().commit();
    }

    /**
     * Метод просмотр списка заметок с фильтрацией по дате
     * @param note Заметка для фильтра
     * @return список заметок с фильтрацией
     */
    public List<Note> getAll(Note note) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Note> allNotes = session.createQuery("select n.name, n.date, n.text from Note n where n.date = '" + note.getDate() + "'").getResultList();
        session.getTransaction().commit();
        return allNotes;
    }
    /**
     * Метод поиска заметок по подстроке по принципу "содержит"
     * @param note Искомая подстрока
     * @return заметки с данной подстрокой
     */
    public List<Note> getNotesLike(Note note) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Note> allNotes = session.createQuery("select n.name, n.date, n.text from Note n where n.name like '%" + note.getText() + "%' or n.text like '%" + note.getText() + "%'").getResultList();
        session.getTransaction().commit();
        return allNotes;
    }
}
