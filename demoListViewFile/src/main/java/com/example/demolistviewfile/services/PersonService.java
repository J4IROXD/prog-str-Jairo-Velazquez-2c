package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for(String line : lines){
            if(line == null || line.isBlank())
                continue;
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String name = parts[0];
                String edad = parts[1];
                String email = parts[2];
                result.add(name + " - " + edad + " - " + email);
            }
        }
        return result;
    }
    public void updatePerson(int index, String name, String email, int age) throws IOException {
        validate(name, email, age);
        List<String> listaOriginal = repo.readAllLines(); //
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLines.add(line); //esta linea esta buena. ya que no esta en null y tampoco esta en blanco

            }
        }
        cleanLines.set(index, name+","+email+","+age);
        repo.saveFile(cleanLines); //sustituir la info en el archivo, dejandolo actualizado
    }

    public void Delate(int index) throws IOException {
        List<String> listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if (line != null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        cleanLines.remove(index);
        repo.saveFile(cleanLines);
    }

    public void addPerson(String name, String email, int edad) throws IOException {
        validate(name, email, edad);
        repo.addNewLine(name + "," + edad + "," + email);
    }

    private void validate(String name, String email, int edad){
        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em = (email == null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es invalido");
        }
        if(edad < 18){
            throw new IllegalArgumentException("La edad es menor a 18 (edad invalida)");
        }
    }
}