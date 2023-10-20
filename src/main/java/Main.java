import entity.ExtSystemsError;
import enums.ErrorClass;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        File file = new File("Логи.xlsx");
        if (!file.exists()) {
            System.out.println("Не могу найти файл");
            return;
        }

        // TODO Разбить их на классы и поменять тип ошибки в Value
        // В таком случае в зависимости от enum можно вызывать разные конструкторы для разных ошибок
        Map<String, ErrorClass> classMap = new HashMap<>();
        classMap.put("Could not execute query: ", ErrorClass.BASE);
        classMap.put("An exception occurred in the database while saving changes for context type ", ErrorClass.BASE);
        classMap.put("An error has occurred in the task of publish expiring certificates events", ErrorClass.BASE);
        classMap.put("Exception SendCommand command", ErrorClass.BASE);
        classMap.put("Событие обработано с ошибками:", ErrorClass.BASE);
        classMap.put("Ошибка актуализации блокировок компании. CompanyId:", ErrorClass.BASE);
        classMap.put("Response already has started, cannot send ErrorDetails object", ErrorClass.BASE);
        classMap.put("Ошибка публикации события об окончании срока действия сертификата пользователя: CorrelationId:", ErrorClass.BASE);
        classMap.put("NHibernate.Exceptions.GenericADOException: ", ErrorClass.BASE);
        classMap.put("Не найдена компания с идентификатором:", ErrorClass.BASE);
        classMap.put("Ошибка обработки события изменения сброса кеша пользователя ", ErrorClass.BASE);
        classMap.put("Невозможно скачать файл по ссылке: ", ErrorClass.BASE);
        classMap.put("Unhandled error during ", ErrorClass.BASE);
        classMap.put("Unable to upload files", ErrorClass.BASE);
        classMap.put("Данные не могут быть обработаны по причине: Ранее была импортирована более поздняя версия сущности.", ErrorClass.BASE);
        classMap.put("Immediate job: ", ErrorClass.BASE);
        classMap.put("Failed to invoke hub method 'joinGroup'.", ErrorClass.BASE);
        classMap.put("Реиндексация компаний завершилась с ошибкой", ErrorClass.BASE);
        classMap.put("job error", ErrorClass.BASE);
        classMap.put("Необработанная ошибка валидации МЧД попытка добавления дубликата", ErrorClass.BASE);
        classMap.put("Unable to execute command: OperationComplete", ErrorClass.BASE);
        classMap.put("МЧД: подписание по старому сертификату", ErrorClass.BASE);
        classMap.put("отстутствует на диске", ErrorClass.BASE);
        classMap.put("System.InvalidOperationException: ", ErrorClass.BASE);
        classMap.put("Не найден КПГЗ с Id:", ErrorClass.BASE);
        classMap.put("The handle is invalid.", ErrorClass.BASE);
        classMap.put("Unable to SendResult CreateAuction OpId:", ErrorClass.BASE);
        classMap.put("Failed executing DbCommand ", ErrorClass.BASE);
        classMap.put("Ошибка обращения к api внешней системы ЕГРЮЛ ДИТ.", ErrorClass.BASE);
        classMap.put("The database operation was expected to affect ", ErrorClass.BASE);
        classMap.put("Unable to get data", ErrorClass.BASE);
        classMap.put("Could not synchronize database state with session", ErrorClass.BASE);
        classMap.put("Ошибка выполнения подписчика на событие завершения применения транзакции ", ErrorClass.BASE);
        classMap.put("Ошибка индексации оферт", ErrorClass.BASE);
        classMap.put("Kaluga workflowId: ", ErrorClass.BASE);
        classMap.put("Unexpected error occured", ErrorClass.BASE);
        classMap.put("Unable to get integration token", ErrorClass.BASE);
        classMap.put("Exception occurred while processing message.", ErrorClass.BASE);
        classMap.put("Ошибка при вызове сервиса ЕИС", ErrorClass.BASE);
        classMap.put("Ошибка доступа к сервису капчи", ErrorClass.BASE);
        classMap.put("Unable to verify and save signature", ErrorClass.BASE);
        classMap.put("Ошибка при обработке запроса", ErrorClass.BASE);
        classMap.put("Произошла ошибка импорта: ", ErrorClass.BASE);
        classMap.put("Архив (УАС) не загрузился/не загружался.", ErrorClass.BASE);
        classMap.put("Ошибка при обращении к сервису ЕИС для проверки токена", ErrorClass.BASE);
        classMap.put("Проверка приглашений для ", ErrorClass.BASE);
        classMap.put("The wait operation timed out", ErrorClass.BASE);
        classMap.put("Ошибка запроса получения информации об операции интеграции:", ErrorClass.BASE);
        classMap.put("An unhandled exception has occurred while executing the request.", ErrorClass.BASE);
        classMap.put("Невозможно запросить данные из УАС для \"Ежедневная выгрузка контрактов и закупок\" по причине:", ErrorClass.BASE);
        classMap.put("Execution Timeout Expired.", ErrorClass.BASE);
        classMap.put("Unable to send company reg request", ErrorClass.BASE);
        classMap.put("An error occurred using a transaction.", ErrorClass.BASE);
        classMap.put("log", ErrorClass.BASE);
        classMap.put("Ошибка обработки запроса на регистрацию/изменение данных компании id:", ErrorClass.BASE);
        classMap.put("Невозможно отправить результаты комнады \"КС: Создание совместной закупки\"", ErrorClass.BASE);
        classMap.put("Действие по автоматическому отказу не разрешено", ErrorClass.BASE);
        classMap.put("Для команды интеграции ", ErrorClass.BASE);
        classMap.put("An unhandled exception was thrown by the application.", ErrorClass.BASE);
        classMap.put("Ошибка получения файлов из каталога", ErrorClass.BASE);
        classMap.put("Ошибка авторизации в интеграционном апи. Login: ", ErrorClass.BASE);
        classMap.put("Ошибка при опросе очереди результатов подписания поставщиком в ЕИС", ErrorClass.BASE);
        classMap.put("Не удалось скачать файл из ЕИС по ссылке: ", ErrorClass.BASE);
        classMap.put("Ошибка при обработке события", ErrorClass.BASE);
        classMap.put("Данные не могут быть проимпортированы по причине", ErrorClass.BASE);
        classMap.put("Ошибка при обращении к сервису ЕИС для запроса информации о контракте", ErrorClass.BASE);
        classMap.put("Ошибка при поиске неиндексированных", ErrorClass.BASE);
        classMap.put("Execution error, job: ", ErrorClass.BASE);
        classMap.put("Unable to send AuctionFinished OpId:", ErrorClass.BASE);
        classMap.put("An exception was thrown during execution of OfferExpirationNotificationJob", ErrorClass.BASE);
        classMap.put("Unable to process OnFlushDirty interceptors", ErrorClass.BASE);
        classMap.put("Unable to set failed for command: ", ErrorClass.BASE);
        classMap.put("An exception has occurred in the task of verification soon expire user machine readable powers of attorney", ErrorClass.BASE);
        classMap.put("Unhandled exception in action execution was thrown, reverting transaction", ErrorClass.BASE);
        classMap.put("Ошибка запроса данных из УАС для \"Ежедневная выгрузка контрактов и закупок\"", ErrorClass.BASE);
        classMap.put("Ошибка запроса статуса самозанятого", ErrorClass.BASE);
        classMap.put("R-FAULT rabbitmq", ErrorClass.BASE);
        classMap.put("Ошибка обработки события измнения сущности Need. Данные события:", ErrorClass.BASE);
        classMap.put("Unable to send contract execution:", ErrorClass.BASE);
        classMap.put("Unable to parse request, query:", ErrorClass.BASE);
        classMap.put("An error has occurred in the task of cleaning ", ErrorClass.BASE);
        classMap.put("An error occurred during stat collection", ErrorClass.BASE);
        classMap.put("is an invalid character.", ErrorClass.BASE);
        classMap.put("An exception occurred while iterating over the results of a query for context type", ErrorClass.BASE);
        classMap.put("OpComplete: ", ErrorClass.BASE);
        classMap.put("Failed to execute query batch: ", ErrorClass.BASE);
        classMap.put("Could not execute command:", ErrorClass.BASE);
        classMap.put("S-FAULT rabbitmq", ErrorClass.BASE);
        classMap.put("Данные не могут быть обработаны по причине: Данный пакет уже был импортирован. ", ErrorClass.BASE);
        classMap.put("Exception while Executing Pp3.Common.Bl.FileStorage.Services.DiskFileStorageProvider:GetFileAsync+fileIdString,ctCancellationToken, args:", ErrorClass.BASE);
        classMap.put("Ошибка при запросе списка интеграционного обмена.", ErrorClass.BASE);
        classMap.put("Unable to process command: ", ErrorClass.BASE);
        classMap.put("Ошибка при расчёте достижений компании.", ErrorClass.BASE);
        classMap.put("Unable to send CreateAuction in external system ", ErrorClass.BASE);

        XSSFWorkbook wb = new XSSFWorkbook(new File("Логи.xlsx"));
        XSSFSheet sheet = wb.getSheet("Логи");

        Map<String, HashMap<String, ExtSystemsError>> dataMap = new HashMap<>();
        // TODO добавить высоту страницы
        for (int i = 0; i < 88856; i++) {
            XSSFRow row = sheet.getRow(i);
            String code = row.getCell(0).getStringCellValue();
            String date = row.getCell(1).getStringCellValue();
            String log = row.getCell(2).getStringCellValue();

            boolean found = false;
            for (String key : classMap.keySet()) {
                if (log.contains(key)) {
                    dataMap.putIfAbsent(key, new HashMap<>());
                    dataMap.get(key).put(log, new ExtSystemsError(code, date, log, 1));
                    found = true;
                    break;
                }
            }
            if (!found) {
                dataMap.putIfAbsent("UNDEFINED", new HashMap<>());
                dataMap.get("UNDEFINED").put(log, new ExtSystemsError(code, date, log, 1));
            }
        }
        // // Тут можно поставить точку остановки чтобы посмотреть через отладчик данные в hashMap
        System.out.println("");
    }

    private static void viewInHashmap() throws IOException, InvalidFormatException {
        File file = new File("Логи.xlsx");
        if (!file.exists()) {
            System.out.println("Не могу найти файл");
            return;
        }

        HashSet<String> keyset = new HashSet<>();
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();

        XSSFWorkbook wb = new XSSFWorkbook(new File("Логи.xlsx"));
        XSSFSheet sheet = wb.getSheet("Логи");

        // TODO добавить высоту
        for (int i = 0; i < 88856; i++) {
            XSSFRow row = sheet.getRow(i);
            String code = row.getCell(0).getStringCellValue();
            String date = row.getCell(1).getStringCellValue();
            String log = row.getCell(2).getStringCellValue();

            if (log.startsWith("S-FAULT rabbitmq")) {
                putDataToMap(hashMap, "S-FAULT rabbitmq", log);
            } else if (log.startsWith("Данные не могут быть проимпортированы по причине")) {
                putDataToMap(hashMap, "Данные не могут быть проимпортированы по причине", log);
            } else if (log.startsWith("Exception SendCommand command")) {
                putDataToMap(hashMap, "Exception SendCommand command", log);
            } else if (log.startsWith("Could not execute query: ")) {
                putDataToMap(hashMap, "Could not execute query: ", log);
            } else if (log.startsWith("Immediate job: ")) {
                putDataToMap(hashMap, "Immediate job: ", log);
            } else if (log.contains("An unhandled exception was thrown by the application.")) {
                putDataToMap(hashMap, "An unhandled exception was thrown by the application.", log);
            } else if (log.startsWith("Kaluga workflowId: ")) {
                putDataToMap(hashMap, "Kaluga workflowId: ", log);
            } else if (log.startsWith("NHibernate.Exceptions.GenericADOException: ")) {
                putDataToMap(hashMap, "NHibernate.Exceptions.GenericADOException: ", log);
            } else if (log.startsWith("Execution error, job: ")) {
                putDataToMap(hashMap, "Execution error, job: ", log);
            } else if (log.startsWith("Ошибка обработки события изменения сброса кеша пользователя ")) {
                putDataToMap(hashMap, "Ошибка обработки события изменения сброса кеша пользователя ", log);
            } else if (log.startsWith("Failed executing DbCommand ")) {
                putDataToMap(hashMap, "Failed executing DbCommand ", log);
            } else if (log.startsWith("Unable to send CreateAuction in external system ")) {
                putDataToMap(hashMap, "Unable to send CreateAuction in external system ", log);
            } else if (log.startsWith("Ошибка авторизации в интеграционном апи. Login: ")) {
                putDataToMap(hashMap, "Ошибка авторизации в интеграционном апи. Login: ", log);
            } else if (log.startsWith("Failed to execute query batch: ")) {
                putDataToMap(hashMap, "Failed to execute query batch: ", log);
            } else if (log.startsWith("Ошибка выполнения подписчика на событие завершения применения транзакции ")) {
                putDataToMap(hashMap, "Ошибка выполнения подписчика на событие завершения применения транзакции ", log);
            } else if (log.startsWith("The handle is invalid.")) {
                putDataToMap(hashMap, "The handle is invalid.", log);
            } else if (log.startsWith("Response already has started, cannot send ErrorDetails object")) {
                putDataToMap(hashMap, "Response already has started, cannot send ErrorDetails object", log);
            } else if (log.contains("is an invalid character.")) {
                putDataToMap(hashMap, "is an invalid character.", log);
            } else if (log.startsWith("Невозможно скачать файл по ссылке: ")) {
                putDataToMap(hashMap, "Невозможно скачать файл по ссылке: ", log);
            } else if (log.startsWith("Реиндексация компаний завершилась с ошибкой")) {
                putDataToMap(hashMap, "Реиндексация компаний завершилась с ошибкой", log);
            } else if (log.startsWith("job error")) {
                putDataToMap(hashMap, "job error", log);
            } else if (log.startsWith("Для команды интеграции ")) {
                putDataToMap(hashMap, "Для команды интеграции ", log);
            } else if (log.contains("Действие по автоматическому отказу не разрешено")) {
                putDataToMap(hashMap, "Действие по автоматическому отказу не разрешено", log);
            } else if (log.startsWith("An error has occurred in the task of cleaning ")) {
                putDataToMap(hashMap, "An error has occurred in the task of cleaning ", log);
            } else if (log.startsWith("Ошибка индексации оферт")) {
                putDataToMap(hashMap, "Ошибка индексации оферт", log);
            } else if (log.startsWith("Unexpected error occured")) {
                putDataToMap(hashMap, "Unexpected error occured", log);
            } else if (log.startsWith("МЧД: подписание по старому сертификату")) {
                putDataToMap(hashMap, "МЧД: подписание по старому сертификату", log);
            } else if (log.startsWith("Ошибка доступа к сервису капчи")) {
                putDataToMap(hashMap, "Ошибка доступа к сервису капчи", log);
            } else if (log.startsWith("Архив (УАС) не загрузился/не загружался.")) {
                putDataToMap(hashMap, "Архив (УАС) не загрузился/не загружался.", log);
            } else if (log.startsWith("The wait operation timed out")) {
                putDataToMap(hashMap, "The wait operation timed out", log);
            } else if (log.startsWith("An unhandled exception has occurred while executing the request.")) {
                putDataToMap(hashMap, "An unhandled exception has occurred while executing the request.", log);
            } else if (log.startsWith("R-FAULT rabbitmq")) {
                putDataToMap(hashMap, "R-FAULT rabbitmq", log);
            } else if (log.startsWith("An exception occurred while iterating over the results of a query for context type")) {
                putDataToMap(hashMap, "An exception occurred while iterating over the results of a query for context type", log);
            } else if (log.startsWith("Unhandled error during ")) {
                putDataToMap(hashMap, "Unhandled error during ", log);
            } else if (log.startsWith("Необработанная ошибка валидации МЧД попытка добавления дубликата")) {
                putDataToMap(hashMap, "Необработанная ошибка валидации МЧД попытка добавления дубликата", log);
            } else if (log.startsWith("Ошибка при обработке события")) {
                putDataToMap(hashMap, "Ошибка при обработке события", log);
            } else if (log.startsWith("An error occurred using a transaction.")) {
                putDataToMap(hashMap, "An error occurred using a transaction.", log);
            } else if (log.startsWith("Ошибка запроса статуса самозанятого")) {
                putDataToMap(hashMap, "Ошибка запроса статуса самозанятого", log);
            } else if (log.startsWith("log")) {
                putDataToMap(hashMap, "log", log);
            } else if (log.contains("Файл с") && log.contains(" отстутствует на диске")) {
                putDataToMap(hashMap, "Файл отстутствует на диске: ", log);
            } else if (log.startsWith("Не найдена компания с идентификатором:")) {
                putDataToMap(hashMap, "Не найдена компания с идентификатором:", log);
            } else if (log.startsWith("The database operation was expected to affect ")) {
                putDataToMap(hashMap, "The database operation was expected to affect ", log);
            } else if (log.startsWith("Проверка приглашений для ")) {
                putDataToMap(hashMap, "Проверка приглашений для ", log);
            } else if (log.startsWith("Произошла ошибка импорта: ")) {
                putDataToMap(hashMap, "Произошла ошибка импорта: ", log);
            } else if (log.startsWith("Ошибка публикации события об окончании срока действия сертификата пользователя: CorrelationId:")) {
                putDataToMap(hashMap, "Ошибка публикации события об окончании срока действия сертификата пользователя: CorrelationId:", log);
            } else if (log.startsWith("OpComplete: ")) {
                putDataToMap(hashMap, "OpComplete: ", log);
            } else if (log.startsWith("Не найден КПГЗ с Id:")) {
                putDataToMap(hashMap, "Не найден КПГЗ с Id:", log);
            } else if (log.startsWith("System.InvalidOperationException: ")) {
                putDataToMap(hashMap, "System.InvalidOperationException: ", log);
            } else if (log.startsWith("Событие обработано с ошибками:")) {
                putDataToMap(hashMap, "Событие обработано с ошибками:", log);
            } else if (log.startsWith("Ошибка актуализации блокировок компании. CompanyId:")) {
                putDataToMap(hashMap, "Ошибка актуализации блокировок компании. CompanyId:", log);
            } else if (log.startsWith("Не удалось скачать файл из ЕИС по ссылке: ")) {
                putDataToMap(hashMap, "Не удалось скачать файл из ЕИС по ссылке: ", log);
            } else if (log.startsWith("Ошибка получения файлов из каталога")) {
                putDataToMap(hashMap, "Ошибка получения файлов из каталога", log);
            } else if (log.startsWith("Данные не могут быть обработаны по причине: Ранее была импортирована более поздняя версия сущности.")) {
                putDataToMap(hashMap, "Данные не могут быть обработаны по причине: Ранее была импортирована более поздняя версия сущности.", log);
            } else if (log.startsWith("Данные не могут быть обработаны по причине: Данный пакет уже был импортирован. ")) {
                putDataToMap(hashMap, "Данные не могут быть обработаны по причине: Данный пакет уже был импортирован. ", log);
            } else if (log.startsWith("Unable to process command: ")) {
                putDataToMap(hashMap, "Unable to process command: ", log);
            } else if (log.startsWith("Unable to verify and save signature")) {
                putDataToMap(hashMap, "Unable to verify and save signature", log);
            } else if (log.startsWith("Ошибка при вызове сервиса ЕИС")) {
                putDataToMap(hashMap, "Ошибка при вызове сервиса ЕИС", log);
            } else if (log.startsWith("Kaluga workflowId:")) {
                putDataToMap(hashMap, "Kaluga workflowId:", log);
            } else if (log.startsWith("Unable to upload files")) {
                putDataToMap(hashMap, "Unable to upload files", log);
            } else if (log.startsWith("An error has occurred in the task of publish expiring certificates events")) {
                putDataToMap(hashMap, "An error has occurred in the task of publish expiring certificates events", log);
            } else if (log.startsWith("Unable to parse request, query:")) {
                putDataToMap(hashMap, "Unable to parse request, query:", log);
            } else if (log.startsWith("Ошибка при поиске неиндексированных")) {
                putDataToMap(hashMap, "Ошибка при поиске неиндексированных", log);
            } else if (log.startsWith("Unable to send AuctionFinished OpId:")) {
                putDataToMap(hashMap, "Unable to send AuctionFinished OpId:", log);
            } else if (log.startsWith("Unable to parse request, query:")) {
                putDataToMap(hashMap, "Unable to parse request, query:", log);
            } else if (log.startsWith("Unable to get integration token")) {
                putDataToMap(hashMap, "Unable to get integration token", log);
            } else if (log.startsWith("Ошибка при запросе списка интеграционного обмена.")) {
                putDataToMap(hashMap, "Ошибка при запросе списка интеграционного обмена.", log);
            } else if (log.startsWith("Ошибка при расчёте достижений компании.")) {
                putDataToMap(hashMap, "Ошибка при расчёте достижений компании.", log);
            } else if (log.startsWith("Could not execute command:")) {
                putDataToMap(hashMap, "Could not execute command:", log);
            } else if (log.startsWith("Ошибка обработки запроса на регистрацию/изменение данных компании id:")) {
                putDataToMap(hashMap, "Ошибка обработки запроса на регистрацию/изменение данных компании id:", log);
            } else if (log.startsWith("Failed to invoke hub method 'joinGroup'.")) {
                putDataToMap(hashMap, "Failed to invoke hub method 'joinGroup'.", log);
            } else if (log.startsWith("An error occurred during stat collection")) {
                putDataToMap(hashMap, "An error occurred during stat collection", log);
            } else if (log.startsWith("Unable to process OnFlushDirty interceptors")) {
                putDataToMap(hashMap, "Unable to process OnFlushDirty interceptors", log);
            } else if (log.startsWith("Unable to SendResult CreateAuction OpId:")) {
                putDataToMap(hashMap, "Unable to SendResult CreateAuction OpId:", log);
            } else if (log.startsWith("Unable to send company reg request")) {
                putDataToMap(hashMap, "Unable to send company reg request", log);
            } else if (log.startsWith("Unable to get data")) {
                putDataToMap(hashMap, "Unable to get data", log);
            } else if (log.startsWith("Could not synchronize database state with session")) {
                putDataToMap(hashMap, "Could not synchronize database state with session", log);
            } else if (log.startsWith("Unable to execute command: OperationComplete")) {
                putDataToMap(hashMap, "Unable to execute command: OperationComplete", log);
            } else if (log.startsWith("An exception occurred in the database while saving changes for context type ")) {
                putDataToMap(hashMap, "An exception occurred in the database while saving changes for context type ", log);
            } else if (log.startsWith("Ошибка при опросе очереди результатов подписания поставщиком в ЕИС")) {
                putDataToMap(hashMap, "Ошибка при опросе очереди результатов подписания поставщиком в ЕИС", log);
            } else if (log.startsWith("Ошибка обращения к api внешней системы ЕГРЮЛ ДИТ.")) {
                putDataToMap(hashMap, "Ошибка обращения к api внешней системы ЕГРЮЛ ДИТ.", log);
            } else if (log.startsWith("Ошибка при обращении к сервису ЕИС для проверки токена")) {
                putDataToMap(hashMap, "Ошибка при обращении к сервису ЕИС для проверки токена", log);
            } else if (log.startsWith("An exception was thrown during execution of OfferExpirationNotificationJob")) {
                putDataToMap(hashMap, "An exception was thrown during execution of OfferExpirationNotificationJob", log);
            } else if (log.startsWith("Execution Timeout Expired.")) {
                putDataToMap(hashMap, "Execution Timeout Expired.", log);
            } else if (log.startsWith("An exception has occurred in the task of verification soon expire user machine readable powers of attorney")) {
                putDataToMap(hashMap, "An exception has occurred in the task of verification soon expire user machine readable powers of attorney", log);
            } else if (log.startsWith("Невозможно запросить данные из УАС для \"Ежедневная выгрузка контрактов и закупок\" по причине:")) {
                putDataToMap(hashMap, "Невозможно запросить данные из УАС для \"Ежедневная выгрузка контрактов и закупок\" по причине:", log);
            } else if (log.startsWith("Exception occurred while processing message.")) {
                putDataToMap(hashMap, "Exception occurred while processing message.", log);
            } else if (log.startsWith("Ошибка при обработке запроса")) {
                putDataToMap(hashMap, "Ошибка при обработке запроса", log);
            } else if (log.startsWith("Ошибка обработки события измнения сущности Need. Данные события:")) {
                putDataToMap(hashMap, "Ошибка обработки события измнения сущности Need. Данные события:", log);
            } else if (log.startsWith("Unable to set failed for command: ")) {
                putDataToMap(hashMap, "Unable to set failed for command: ", log);
            } else if (log.startsWith("Exception while Executing Pp3.Common.Bl.FileStorage.Services.DiskFileStorageProvider:GetFileAsync+fileIdString,ctCancellationToken, args:")) {
                putDataToMap(hashMap, "Exception while Executing Pp3.Common.Bl.FileStorage.Services.DiskFileStorageProvider:GetFileAsync+fileIdString,ctCancellationToken, args:", log);
            } else if (log.startsWith("Unhandled exception in action execution was thrown, reverting transaction")) {
                putDataToMap(hashMap, "Unhandled exception in action execution was thrown, reverting transaction", log);
            } else if (log.startsWith("Ошибка запроса данных из УАС для \"Ежедневная выгрузка контрактов и закупок\"")) {
                putDataToMap(hashMap, "Ошибка запроса данных из УАС для \"Ежедневная выгрузка контрактов и закупок\"", log);
            } else if (log.startsWith("Ошибка запроса получения информации об операции интеграции:")) {
                putDataToMap(hashMap, "Ошибка запроса получения информации об операции интеграции:", log);
            } else if (log.startsWith("Невозможно отправить результаты комнады \"КС: Создание совместной закупки\"")) {
                putDataToMap(hashMap, "Невозможно отправить результаты комнады \"КС: Создание совместной закупки\"", log);
            } else if (log.startsWith("Unable to send contract execution:")) {
                putDataToMap(hashMap, "Unable to send contract execution:", log);
            } else if (log.startsWith("Ошибка при обращении к сервису ЕИС для запроса информации о контракте")) {
                putDataToMap(hashMap, "Ошибка при обращении к сервису ЕИС для запроса информации о контракте", log);
            } else {
                putDataToMap(hashMap, "UNDEFINED", log);
            }
        }

//        StringBuilder text = new StringBuilder();
//        int j = 0;
//        for (String t :hashMap.keySet()) {
//            text.append("hashMap.put(").append("\"").append(t).append("\", ErrorClass.BASE);").append("\n");
//        }

        StringBuilder textForAndrey = new StringBuilder();
        int i = 0;
        for (String key : hashMap.keySet()) {
            String firstError = hashMap.get(key).toArray()[0].toString();
            textForAndrey.append(++i).append(" : ").append(firstError.split("\n")[0]).append("\n");
        }
        // Тут можно поставить точку остановки чтобы посмотреть через отладчик данные в hashMap
        System.out.println(textForAndrey);
    }

    private static void putDataToMap(HashMap<String, HashSet<String>> hashMap, String key, String log) {
        hashMap.putIfAbsent(key, new HashSet<>());
        hashMap.get(key).add(log);
    }

    private static void gettingLogTypes() throws IOException, InvalidFormatException {
        File file = new File("Логи.xlsx");
        if (!file.exists()) {
            System.out.println("Не могу найти файл");
            return;
        }

        HashSet<String> keyset = new HashSet<>();
        HashMap<String, HashMap<String, Integer>> hashMap = new HashMap<>();

        XSSFWorkbook wb = new XSSFWorkbook(new File("Логи.xlsx"));
        XSSFSheet sheet = wb.getSheet("Логи");
        // TODO добавить высоту
        for (int i = 0; i < 88856; i++) {
            XSSFRow row = sheet.getRow(i);
            String code = row.getCell(0).getStringCellValue();
            String date = row.getCell(1).getStringCellValue();
            String log = row.getCell(2).getStringCellValue();

            String key = log.substring(0, Math.min(log.length(), 10));

            hashMap.putIfAbsent(key, new HashMap<>());
            hashMap.get(key).merge(log, 1, Integer::sum);
        }

        HashSet<String> temp = new HashSet<>();
        for (String k : hashMap.keySet()) {
            temp.add(hashMap.get(k).keySet().toArray()[0].toString());
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        for (String k : temp) {
            res.append(++i).append(" : ").append(k.split("\n")[0]).append("\n");
        }
        System.out.println(res);
        wb.close();
    }
}
