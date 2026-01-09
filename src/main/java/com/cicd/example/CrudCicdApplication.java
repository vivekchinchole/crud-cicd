package com.cicd.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudCicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudCicdApplication.class, args);
	}

}

// Pipeline scipt in jenkins


//pipeline {
//	agent any
//
//	environment {
//		DOCKER_IMAGE = "vivekchinchole/crud-app"
//		DOCKER_TAG   = "latest"
//		KUBECONFIG   = "C:\\ProgramData\\Jenkins\\.kube\\config"
//	}
//
//	stages {
//
//		stage('Checkout Code') {
//			steps {
//				git branch: 'main',
//						url: 'https://github.com/vivekchinchole/crud-cicd.git'
//			}
//		}
//
//		stage('Build with Maven') {
//			steps {
//				bat 'mvn clean package -DskipTests'
//			}
//		}
//
//		stage('Build Docker Image') {
//			steps {
//				bat "docker build -t %DOCKER_IMAGE%:%DOCKER_TAG% ."
//			}
//		}
//
//		stage('Docker Login & Push') {
//			steps {
//				withCredentials([
//						usernamePassword(
//								credentialsId: 'dockerhub-credentials',
//						usernameVariable: 'DOCKER_USER',
//						passwordVariable: 'DOCKER_PASS'
//                    )
//                ]) {
//					bat """
//                    docker login -u %DOCKER_USER% -p %DOCKER_PASS%
//                    docker push %DOCKER_IMAGE%:%DOCKER_TAG%
//                    """
//				}
//			}
//		}
//
//		stage('Deploy to Kubernetes') {
//			steps {
//				bat """
//                echo Using kubeconfig: %KUBECONFIG%
//                kubectl config get-contexts
//                kubectl config use-context minikube
//                kubectl apply -f k8s/ --validate=false
//                """
//			}
//		}
//	}
//
//	post {
//		success {
//			echo 'CI/CD Pipeline completed successfully'
//		}
//		failure {
//			echo 'CI/CD Pipeline failed'
//		}
//	}
//}
