package {{inputs.project_group_id}}

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class APIApplication

fun main(args: Array<String>) {
  runApplication<APIApplication>(*args)
}
