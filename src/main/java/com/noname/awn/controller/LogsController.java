package com.noname.awn.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noname.awn.converter.LogsConverter;
import com.noname.awn.dto.LogsDTO;
import com.noname.awn.model.Abis;
import com.noname.awn.model.Certificators;
import com.noname.awn.model.Customers;
import com.noname.awn.model.Devices;
import com.noname.awn.model.Documents;
import com.noname.awn.model.Flows;
import com.noname.awn.model.Infos;
import com.noname.awn.model.Licences;
import com.noname.awn.model.Limits;
import com.noname.awn.model.Logs;
import com.noname.awn.model.Modules;
import com.noname.awn.model.Notarizations;
import com.noname.awn.model.Notifications;
import com.noname.awn.model.Operations;
import com.noname.awn.model.Parameters;
import com.noname.awn.model.Payments;
import com.noname.awn.model.Presets;
import com.noname.awn.model.Seats;
import com.noname.awn.model.Sequences;
import com.noname.awn.model.Settings;
import com.noname.awn.model.Status;
import com.noname.awn.model.Steps;
import com.noname.awn.model.Subscriptions;
import com.noname.awn.model.Tasks;
import com.noname.awn.model.Templates;
import com.noname.awn.model.Users;
import com.noname.awn.model.Wallets;
import com.noname.awn.repository.AbisRepository;
import com.noname.awn.repository.CertificatorsRepository;
import com.noname.awn.repository.CustomersRepository;
import com.noname.awn.repository.DevicesRepository;
import com.noname.awn.repository.DocumentsRepository;
import com.noname.awn.repository.FlowsRepository;
import com.noname.awn.repository.InfosRepository;
import com.noname.awn.repository.LicencesRepository;
import com.noname.awn.repository.LimitsRepository;
import com.noname.awn.repository.LogsRepository;
import com.noname.awn.repository.ModulesRepository;
import com.noname.awn.repository.NotarizationsRepository;
import com.noname.awn.repository.NotificationsRepository;
import com.noname.awn.repository.OperationsRepository;
import com.noname.awn.repository.ParametersRepository;
import com.noname.awn.repository.PaymentsRepository;
import com.noname.awn.repository.PresetsRepository;
import com.noname.awn.repository.SeatsRepository;
import com.noname.awn.repository.SequencesRepository;
import com.noname.awn.repository.SettingsRepository;
import com.noname.awn.repository.StatusRepository;
import com.noname.awn.repository.StepsRepository;
import com.noname.awn.repository.SubscriptionsRepository;
import com.noname.awn.repository.TasksRepository;
import com.noname.awn.repository.TemplatesRepository;
import com.noname.awn.repository.UsersRepository;
import com.noname.awn.repository.WalletsRepository;;

@RestController
@RequestMapping(value = "/api/logs")
public class LogsController {

	@Autowired
	private LogsRepository repository;
	
	@Autowired
	private AbisRepository abisRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private CustomersRepository customersRepository;
	
	@Autowired
	private OperationsRepository operationsRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ParametersRepository parametersRepository;
	
	@Autowired
	private SequencesRepository sequencesRepository;
	
	@Autowired
	private StepsRepository stepsRepository;
	
	@Autowired
	private InfosRepository infosRepository;
	
	@Autowired
	private DocumentsRepository documentsRepository;
	
	@Autowired
	private TemplatesRepository templatesRepository;
	
	@Autowired
	private FlowsRepository flowsRepository;
	
	@Autowired
	private NotificationsRepository notificationsRepository;
	
	@Autowired
	private TasksRepository tasksRepository;
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;
	
	@Autowired
	private SettingsRepository settingsRepository;
	
	@Autowired
	private ModulesRepository modulesRepository;
	
	@Autowired
	private PresetsRepository presetsRepository;
	
	@Autowired
	private LimitsRepository limitsRepository;
	
	@Autowired
	private CertificatorsRepository certificatorsRepository;
	
	@Autowired
	private SeatsRepository seatsRepository;
	
	@Autowired
	private DevicesRepository devicesRepository;
	
	@Autowired
	private LicencesRepository licencesRepository;
	
	@Autowired
	private NotarizationsRepository notarizationsRepository;
	
	@Autowired
	private WalletsRepository walletsRepository;
	
	@Autowired
	private PaymentsRepository paymentsRepository;

    @Autowired
    private LogsConverter logsConverter;
	
	@GetMapping("/")
	public List<Logs> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Logs getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Logs updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody LogsDTO logsDTO) {
		Abis abis = abisRepository.findBy_id(logsDTO.getId_abis());
		Users user = usersRepository.findBy_id(logsDTO.getId_user());
		Customers customers = customersRepository.findBy_id(logsDTO.getId_customer());
		Operations operations = operationsRepository.findBy_id(logsDTO.getId_operation());
		Status status = statusRepository.findBy_id(logsDTO.getId_status());
		Parameters parameters = parametersRepository.findBy_id(logsDTO.getId_parameter());
		Sequences sequences = sequencesRepository.findBy_id(logsDTO.getId_sequence());
		Steps steps = stepsRepository.findBy_id(logsDTO.getId_step());
		Infos infos = infosRepository.findBy_id(logsDTO.getId_info());
		Documents documents = documentsRepository.findBy_id(logsDTO.getId_document());
		Templates templates = templatesRepository.findBy_id(logsDTO.getId_template());
		Flows flows = flowsRepository.findBy_id(logsDTO.getId_flow());
		Notifications notifications = notificationsRepository.findBy_id(logsDTO.getId_notification());
		Tasks tasks = tasksRepository.findBy_id(logsDTO.getId_task());
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(logsDTO.getId_subscription());
		Settings settings = settingsRepository.findBy_id(logsDTO.getId_setting());
		Modules modules = modulesRepository.findBy_id(logsDTO.getId_module());
		Presets presets = presetsRepository.findBy_id(logsDTO.getId_limit());
		Certificators certificators = certificatorsRepository.findBy_id(logsDTO.getId_certificator());
		Seats seats = seatsRepository.findBy_id(logsDTO.getId_seat());
		Devices devices = devicesRepository.findBy_id(logsDTO.getId_device());
		Licences licences = licencesRepository.findBy_id(logsDTO.getId_licence());
		Notarizations notarizations = notarizationsRepository.findBy_id(logsDTO.getId_notarization());
		Wallets wallets = walletsRepository.findBy_id(logsDTO.getId_wallet());
		Payments payments = paymentsRepository.findBy_id(logsDTO.getId_payment());
		Limits limits = limitsRepository.findBy_id(logsDTO.getId_limit());
		
		Logs logs = logsConverter.convertToEntity(logsDTO);
		logs.setAbis(abis);
		logs.setUsers(user);
		logs.setCustomers(customers);
		logs.setOperations(operations);
		logs.setStatuss(status);
		logs.setParameters(parameters);
		logs.setSequences(sequences);
		logs.setSteps(steps);
		logs.setInfos(infos);
		logs.setDocuments(documents);
		logs.setTemplates(templates);
		logs.setFlows(flows);
		logs.setNotifications(notifications);
		logs.setNotifications(notifications);
		logs.setTasks(tasks);
		logs.setSubscriptions(subscriptions);
		logs.setSettings(settings);
		logs.setModules(modules);
		logs.setPresets(presets);
		logs.setLimits(limits);
		logs.setCertificators(certificators);
		logs.setDevices(devices);
		logs.setLicences(licences);
		logs.setNotarizations(notarizations);
		logs.setWallets(wallets);
		logs.setPayments(payments);
		logs.setSeats(seats);
		
		logs.set_id(id);
		repository.save(logs);
		return logs;
	}

	@PostMapping("/")
	@Transactional
	public Logs createAbis(@Valid @RequestBody LogsDTO logsDTO) {
		logsDTO.set_id(ObjectId.get());
		Abis abis = abisRepository.findBy_id(logsDTO.getId_abis());
		Users user = usersRepository.findBy_id(logsDTO.getId_user());
		Customers customers = customersRepository.findBy_id(logsDTO.getId_customer());
		Operations operations = operationsRepository.findBy_id(logsDTO.getId_operation());
		Status status = statusRepository.findBy_id(logsDTO.getId_status());
		Parameters parameters = parametersRepository.findBy_id(logsDTO.getId_parameter());
		Sequences sequences = sequencesRepository.findBy_id(logsDTO.getId_sequence());
		Steps steps = stepsRepository.findBy_id(logsDTO.getId_step());
		Infos infos = infosRepository.findBy_id(logsDTO.getId_info());
		Documents documents = documentsRepository.findBy_id(logsDTO.getId_document());
		Templates templates = templatesRepository.findBy_id(logsDTO.getId_template());
		Flows flows = flowsRepository.findBy_id(logsDTO.getId_flow());
		Notifications notifications = notificationsRepository.findBy_id(logsDTO.getId_notification());
		Tasks tasks = tasksRepository.findBy_id(logsDTO.getId_task());
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(logsDTO.getId_subscription());
		Settings settings = settingsRepository.findBy_id(logsDTO.getId_setting());
		Modules modules = modulesRepository.findBy_id(logsDTO.getId_module());
		Presets presets = presetsRepository.findBy_id(logsDTO.getId_limit());
		Certificators certificators = certificatorsRepository.findBy_id(logsDTO.getId_certificator());
		Seats seats = seatsRepository.findBy_id(logsDTO.getId_seat());
		Devices devices = devicesRepository.findBy_id(logsDTO.getId_device());
		Licences licences = licencesRepository.findBy_id(logsDTO.getId_licence());
		Notarizations notarizations = notarizationsRepository.findBy_id(logsDTO.getId_notarization());
		Wallets wallets = walletsRepository.findBy_id(logsDTO.getId_wallet());
		Payments payments = paymentsRepository.findBy_id(logsDTO.getId_payment());
		Limits limits = limitsRepository.findBy_id(logsDTO.getId_limit());
		
		Logs logs = logsConverter.convertToEntity(logsDTO);
		logs.setAbis(abis);
		logs.setUsers(user);
		logs.setCustomers(customers);
		logs.setOperations(operations);
		logs.setStatuss(status);
		logs.setParameters(parameters);
		logs.setSequences(sequences);
		logs.setSteps(steps);
		logs.setInfos(infos);
		logs.setDocuments(documents);
		logs.setTemplates(templates);
		logs.setFlows(flows);
		logs.setNotifications(notifications);
		logs.setNotifications(notifications);
		logs.setTasks(tasks);
		logs.setSubscriptions(subscriptions);
		logs.setSettings(settings);
		logs.setModules(modules);
		logs.setPresets(presets);
		logs.setLimits(limits);
		logs.setCertificators(certificators);
		logs.setDevices(devices);
		logs.setLicences(licences);
		logs.setNotarizations(notarizations);
		logs.setWallets(wallets);
		logs.setPayments(payments);
		logs.setSeats(seats);
		repository.save(logs);
		return logs;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
