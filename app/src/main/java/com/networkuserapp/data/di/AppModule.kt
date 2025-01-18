import com.networkuserapp.data.local.dao.AddressDao
import com.networkuserapp.data.local.dao.CompanyDao
import com.networkuserapp.data.local.dao.UserDao
import com.networkuserapp.data.repository.AddressRepository
import com.networkuserapp.data.repository.CompanyRepository
import com.networkuserapp.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCompanyRepository(companyDao: CompanyDao): CompanyRepository {
        return CompanyRepository(companyDao)
    }

    @Provides
    @Singleton
    fun provideAddressRepository(addressDao: AddressDao): AddressRepository {
        return AddressRepository(addressDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}