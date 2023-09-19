package co.edu.unipamplona.ciadti.rap.services.controller;

import co.edu.unipamplona.ciadti.rap.services.exception.RapException;
import co.edu.unipamplona.ciadti.rap.services.model.general.entity.PersonaNaturalGeneralEntity;
import co.edu.unipamplona.ciadti.rap.services.model.general.service.PersonaNaturalGeneralService;
import co.edu.unipamplona.ciadti.rap.services.util.converter.ParameterConverter;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/person")
public class PersonaController {

    private final PersonaNaturalGeneralService personaNaturalGeneralService;
    private final ParameterConverter parameterConverter;

    @Operation(
            summary = "Obtener o listar las personas con su información personal.",
            description = "Obtiene o lista las personas de acuerdo a ciertas variables o parámetros. " +
                    "Args: id: identificador de la persona. " +
                    "request: Usado para obtener los parámetros pasados y que serán usados para filtrar (Clase PersonaNaturalGeneralEntity). " +
                    "Returns: Objeto o lista de objetos con información de la persona. " +
                    "Nota: Puede hacer uso de todos, de ninguno, o de manera combinada de las variables o parámetros especificados. ")
    @GetMapping(value = {"", "/{id}"})
    public ResponseEntity<?> get(@PathVariable(required = false) Long id, HttpServletRequest request)  throws RapException {
        PersonaNaturalGeneralEntity filter = (PersonaNaturalGeneralEntity) parameterConverter.converter(request.getParameterMap(), PersonaNaturalGeneralEntity.class);
        filter.setId(id==null ? filter.getId() : id);
        Object objeto = personaNaturalGeneralService.findAllFilteredBy(filter);
        if (id == null) {
            if (((List<?>) objeto).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else {
            if (((List<?>) objeto).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            objeto = ((List<?>) objeto).get(0);
        }
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    @Operation(
        summary = "Obtener o listar las personas paginadas con su información personal.",
        description = "Obtiene o lista las personas paginadas con DataTable de acuerdo a ciertas variables o parámetros. " +
                "Args: input: objeto DataTablesInput. " +
                "Returns: Objeto o lista de objetos paginados con información de la persona. " +
                "Nota: Puede ser usado para paginar los registros o buscar registros paginados con DataTable. ")
    @RequestMapping(value = "/paged", method = {RequestMethod.GET, RequestMethod.POST})
    public  ResponseEntity<?>  getPaged(@RequestBody DataTablesInput input) {
        return new ResponseEntity<>(personaNaturalGeneralService.findAll(input), HttpStatus.OK);
    }

}
