package com.techacademy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user")
public class User implements Serializable{
        private static final long serialVersionUID = 1L;

        /** 性別の列挙 **/
        public static enum Gender{
                男性, 女性
        }

        /** ID */
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;

        /** 名前 */
        @Column(length=20, nullable=false)
        @NotEmpty
        @Length(max=20)
        private String name;

        /** 性別 */
        @Column(length=2)
        @Enumerated(EnumType.STRING)
        private Gender gender;

        /** 年齢 */
        @Min(value=0)
        private Integer age;

        /** メールアドレス */
        @Column(length=50)
        @Email
        @Length(max=50)
        private String email;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Gender getGender() {
                return gender;
        }

        public void setGender(Gender gender) {
                this.gender = gender;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}