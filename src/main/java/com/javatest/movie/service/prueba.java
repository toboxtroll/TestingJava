//package com.javatest.movie.service;
//
public class prueba {
//    public Collection<Movie> findByTemplate(Movie template) {
//
//        if (template.getId() != null) {
//            Movie movie = findById(template.getId());
//            return movie != null ? Collections.singletonList(movie) : new ArrayList<>();
//        }
//
//        if (template.getMinutes() < 0) {
//            throw new IllegalArgumentException("duration must be greater or equal than zero.");
//        }
//
//        List<Predicate<Movie>> filters = new ArrayList<>();
//
//        if (template.getName() != null) {
//            filters.add(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase().trim()));
//        }
//        if (template.getMinutes() != null) {
//            filters.add(movie -> movie.getMinutes() <= template.getMinutes());
//        }
//        if (template.getGenre() != null) {
//            filters.add(movie -> movie.getGenre().equals(template.getGenre()));
//        }
//        if (template.getDirector() != null) {
//            filters.add(movie -> movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase().trim()));
//        }
//
//        return repository.findAll().stream()
//                .filter(movie -> filters.stream().allMatch(filter -> filter.test(movie)))
//                .collect(Collectors.toList());
//    }
}
