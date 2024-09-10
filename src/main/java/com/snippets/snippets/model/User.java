    package com.snippets.snippets.model;

    import jakarta.persistence.*;
    import lombok.Data;

    @Data
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String username;
        private String password;
        private String name;

        public User(){};

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String username, String password){
            this.username = username;
            this.password = password;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString(){
            return "User [id=" + id + ", name=" + username + ", password=" + password
                    + "]";
        }
    }
