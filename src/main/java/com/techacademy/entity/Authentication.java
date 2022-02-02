package com.techacademy.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Authentication {

        /** ログインユーザ名 */
        @Id
        private String loginUser;

        /** パスワード */
        private String password;

        /** 有効日付 */
        private Date validDate;

        /** ユーザID */
        @OneToOne(optional=false)
        @JoinColumn(name="userId", referencedColumnName="id")
        private User user;

        public String getLoginUser() {
                return loginUser;
        }

        public void setLoginUser(String loginUser) {
                this.loginUser = loginUser;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Date getValidDate() {
                return validDate;
        }

        public void setValidDate(Date validDate) {
                this.validDate = validDate;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}
