package com.example.apprende4bg12.data.datasources

import com.example.apprende4bg12.R
import com.example.apprende4bg12.data.models.CompanyModel
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.data.models.ServiceModel
import com.example.apprende4bg12.data.models.UserModel

class MemoryDataSource {

    suspend fun getServices(): List<ServiceModel>{
        return listOf(
            ServiceModel(
                "1",
                R.drawable.programming.toString(),
                "Programacion",
                "Desarrolla tus apps moviles o web y crea tu propio estilo en el mercado",
            ),
            ServiceModel(
                "2",
                R.drawable.finance.toString(),
                "Finanzas",
                "Integrate al mundo de las finanzas y desarrolla planes de empresariales"
            ),
            ServiceModel(
                "3",
                R.drawable.musica.toString(),
                "Musica",
                "Crear, canta y compone nuevos sonidos que hagan vibrar el mundo"
            ),
            ServiceModel(
                "4",
                R.drawable.habblandas.toString(),
                "Habilidades Blandas",
                "Mejora tus softskills e integrate a la nueva manera de trabajar en equipo"
            ),

        )
    }

    suspend fun getCourses(category: String?): List<CoursesModel>{
        val list = listOf(
            CoursesModel("1",
                R.drawable.angular.toString(),"JavaScript","Programacion",4.5,"Curso sobre fundamentos de javascript"),
            CoursesModel("2",
                R.drawable.angular.toString(),"Angular","Programacion",4.8,"Crea tus aplicativos web con este framework"),
            CoursesModel("3",
                R.drawable.angular.toString(),"NodeJS","Programacion",4.2,"Inicia a diversificar tu contenido web con node.js"),
            CoursesModel("4",
                R.drawable.angular.toString(),"Kotlin","Programacion", 5.0, "Da tus primeros pasos por el desarrollo de aplicativos moviles"),
            CoursesModel("5",
                R.drawable.angular.toString(),"CSS","Programacion",3.9, "Dale estilo a tus paginas web con las herramientas que te ofrece CSS"),
            CoursesModel("6",
                R.drawable.angular.toString(),"HTML","Programacion", 4.0, "Inicia creando tus plantillas web para entrar en este mundo fascinante"),
            CoursesModel("7",
                R.drawable.angular.toString(),"Java","Programacion", 4.7,"Crea programas aplicables acorde a tus requerimientos, diversifica el softwae"),
            /* Different Section*/
            CoursesModel("8",
                R.drawable.angular.toString(),"Finanzas Personales","Finanzas", 4.6, "Aprende a manjear tus propias finanzas y las de tu hogar"),
            CoursesModel("9",
                R.drawable.angular.toString(),"Manejo de Deudas","Finanzas",3.7,"Crea diversas estrategias para el control de tus gastos"),
            CoursesModel("10",
                R.drawable.angular.toString(),"Creatividad Financiera","Finanzas", 3.9, "Investiga y desarrolla planes de financiación con nosotros"),
            CoursesModel("11",
                R.drawable.angular.toString(),"Trading","Finanzas",4.6, "Aprende como los grandes invierten su dinero y gana dinero con un par de clicks"),
            /* Different Section */
            CoursesModel("12",
                R.drawable.angular.toString(),"Producción Musical","Musica",4.2,"Crea tus propias producciones y genera diversos sonidos"),
            CoursesModel("13",
                R.drawable.angular.toString(),"Doblaje de Voz","Musica",5.0, "Dale vida a los personajes animados o caracteriza a los actores mas reconocidos"),
            CoursesModel("14",
                R.drawable.angular.toString(),"Tecnicas de Locución","Musica",4.4,"Habla como un profesional en la radio"),
            CoursesModel("15",
                R.drawable.angular.toString(),"Curso de DJ","Musica",4.7,"Muestra tus habilidades para crear nuevos sonidos y subete a los mejores escenarios mundiales"),
            /* Different Section*/
            CoursesModel("16",
                R.drawable.angular.toString(),"Liderazgo","Habilidades Blandas",4.6,"Aprende como las grandes empresas forman a sus lideres y crean proyectos"),
            CoursesModel("17",
                R.drawable.angular.toString(),"Inteligencia emocional","Habilidades Blandas",4.2, "Controla los aspectos e tu vida y no dejes que las adversidades se interpongan"),
            CoursesModel("18",
                R.drawable.angular.toString(),"Habilidades de Negociación","Habilidades Blandas",4.4,"Desarrolla tu habilidad para ser uno de los granes lobos de wallstreet"),
        )
        if(category != null){
            return list.filter { c -> c.description == category }
        }
        return list
    }

    suspend fun getInfo(): CompanyModel{
        return  CompanyModel(
            "1",
            "Apprende",
            60.17032407155752,
            24.950317898811033


        )

    }

    suspend fun getCurrentUser(): UserModel{
        return UserModel(
            "1",
            "Adriel de los Adrieles",
            "Adrielel+kpo@correo.com",
            "https://64.media.tumblr.com/5307bbd2c1e8d1499fc25318201b4cd7/tumblr_oidv0oQxL31vl7x77o1_1280.png"
        )
    }


}